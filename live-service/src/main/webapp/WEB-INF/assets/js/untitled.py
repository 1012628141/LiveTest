#encoding:utf-8
import os
import urllib2
import re
import sys
import MySQLdb 
import json
import smtplib
import time
from email.mime.text import MIMEText  
from email.header import Header 
whiteList=['shanghai','guangdong','httpdvb']
strhttp="http"
#online
# dbIp="112.35.28.111"
# dbUser="live_online"
# dbPassWord="readyidu"
# dbName="live_online"
# #off
dbIp="192.168.4.99"
dbUser="readyidu"
dbPassWord="readyidu@2015"
dbName="xy_live"
class channel(object):
	"""docstring for source"""
	def __init__(self, id):
		super(channel, self).__init__()
		self.id = id,
		self.channelname = ""
		self.source = []
		
deathSource = dict()
reviveSource = dict()
def createConnect():
	db=MySQLdb.connect(dbIp,dbUser,dbPassWord,dbName,charset='utf8')
	cursor=db.cursor()
	count = cursor.execute("select whitestr from t_channel_whitelist")
	whitedata=cursor.fetchmany(count)
	# db=MySQLdb.connect("112.35.28.111","live_online","readyidu","live_online")
	db=MySQLdb.connect(dbIp,dbUser,dbPassWord,dbName,charset='utf8')
	cursor=db.cursor()
	count=cursor.execute("select parentid,source from t_channel_source where is_delete =0 and parentid in (select id from t_channel where typeid in (200,300))")
	print "查询结果：%s" %count
	data=cursor.fetchmany(count)
	falseUrl=[]
	for x in data:
		id=x[0]
		source=x[1]
		print "查询结果：id:%s,source:%s" %(id,source)
		isWhite=False
		for white in whitedata:
			if white[0] in source:
				isWhite=True
		if isWhite:
			continue
		index=1
		result= gettag(source,index)
		if result==False:
			falseUrl.append(source)
			value = deathSource.setdefault(id)
			print "value:%s"%value
			if value == None:
				deathSource[id] = channel(id)
			deathSource[id].source.append(source)
		print "验证结果：%s" %result
		print "********************************"
	db.close()
	print "输出错误url"
	db=MySQLdb.connect(dbIp,dbUser,dbPassWord,dbName)
	cursor=db.cursor()
	for x in falseUrl:
		try:
			print "update t_channel_source set is_delete = 2,modifty_time=now() where source='%s'"%x
			cursor.execute("update t_channel_source set is_delete = 2,modifty_time=now() where source='%s'"%x)
			db.commit()
		except Exception as e:
			print e
			db.rollback()
		else:
			pass
		finally:
			pass
		print x
	print len(falseUrl)
	# checkAgain(noneUrl,db)
def createDeathConnect():
	# db=MySQLdb.connect("112.35.28.111","live_online","readyidu","live_online")
	db=MySQLdb.connect(dbIp,dbUser,dbPassWord,dbName,charset='utf8')
	cursor=db.cursor()
	count = cursor.execute("select whitestr from t_channel_whitelist")
	whitedata=cursor.fetchmany(count)
	db=MySQLdb.connect(dbIp,dbUser,dbPassWord,dbName,charset='utf8')
	cursor=db.cursor()
	count=cursor.execute("select parentid,source from t_channel_source where is_delete !=0 and parentid in (select id from t_channel where typeid in (200,300))")
	print "查询结果：%s" %count
	data=cursor.fetchmany(count)
	TrueUrl=[]
	for x in data:
		id=x[0]
		source=x[1]
		print "查询结果：id:%s,source:%s" %(id,source)
		isWhite=False
		for white in whitedata:
			if white[0] in source:
				isWhite=True
		print isWhite
		if isWhite:
			continue
		index=1
		result= gettag(source,index)
		if result==True:
			TrueUrl.append(source)
			value = reviveSource.setdefault(id)
			print "value:%s"%value
			if value == None:
				reviveSource[id] = channel(id)
			reviveSource[id].source.append(source)
		print "验证结果：%s" %result
		print "********************************"
	db.close()
	print "输出复活url"
	db=MySQLdb.connect(dbIp,dbUser,dbPassWord,dbName,charset='utf8')
	cursor=db.cursor()
	for x in TrueUrl:
		try:
			print "update t_channel_source set is_delete = 0,modifty_time=now() where source='%s'"%x
			cursor.execute("update t_channel_source set is_delete = 0,modifty_time=now() where source='%s'"%x)
			db.commit()
		except Exception as e:
			print e
			db.rollback()
		else:
			pass
		finally:
			pass
		print x
	print len(TrueUrl)
	# checkAgain(noneUrl,db)
def isInList(str,list):
	for x in list:
		if str in x:
			print x
			print "return true"
			return True
	return False
def gettag(url,index):
	print url
	reStrTs="[A-Za-z0-9.:/_-]*ts[a-z0-9A-Z-_,.?=&+%:/]*"
	reStrM3u8="[A-Za-z0-9.:/_-]*\.m3u8[a-z0-9A-Z-_,.?=&+%:/]*"
	strSource="sourceUri"
	strRtmp="rtmp://"
	if strSource in url:
		url=getSource(url)
		print url
	if url==None:
		return False
	if "flv" in url:
		return True
	if strRtmp in url:
		return True
		result=watchRtmp(url)
	urls=url.split("#")
	urllist=urls[0].split("/")
	try:
		if "$" in url:
			url=url.split("$")[0]
		print url
		req=urllib2.Request(url)
		res=urllib2.urlopen(req,timeout=5)
		contentType=res.headers['Content-Type']
		print "c" +contentType
		if "flv" in contentType:
			return True
			pass
		print "startDown"
		resbody=res.readlines()
		print len(resbody)
		if len(resbody)>100 :
			if len(resbody)>5000:
				return True
			if not isInList("ts",resbody):
				return False
	except AttributeError as a:
		print a
		print "AttributeError"
		return gettag(url,1)
	except Exception as e:
		print e
		return False 
	else:
		pass
	finally:
		pass
	for x in resbody:
		# print htmlsource.text
		# print "************"
		# print x.text
		if x==None or x.strip()=="":
			continue
		p=re.compile(reStrTs)
		resultlist=p.findall(x)
		if len(resultlist)!=0:
			for x in resultlist:
				try:
					if strhttp in x:
						return True
					resu = pullTsInfo(urllist, x)
					print resu
					if resu!=None:
						return True
				except Exception as e:
					print  e
					continue

		# print "tsFalse"
		p=re.compile(reStrM3u8)
		resultlist=p.findall(x)
		if len(resultlist)!=0:
			for x in resultlist:
				# if index>5:
				# 	return false;
				index+=1
				murl=None
				if strhttp in x:
					murl=x
				else :
					murl=pullTsInfo(urllist,x)
				print murl
				result=gettag(murl,index)
				# print "m3u8返回：%s" %murl
				return result
		if "#" not in x:
			index+=1
			murl=pullTsInfo(urllist,x)
			print murl
			result=gettag(murl,index)
			if result!=None:
				return result
	return False
		# print "m3u8False"
def watchRtmp(strRtmp):
	cmdStr="rtmpdump -r %s" %strRtmp
	result=os.popen(cmdStr).readline()
	# result.readline()
	if result!=None and result!="":
		return True
	return False
def getSource(strSource):
	if strSource== None:
		return False
	req=urllib2.Request("http://112.35.30.146:19090/source/source.do?sourceUri="+strSource)
	# req=urllib2.Request("http://localhost:6262/source/source.do?sourceUri="+strSource)
	res=urllib2.urlopen(req).read()
	jsonData=json.loads(res)
	if jsonData['data']==None or jsonData['data']=="":
		return None
	return jsonData['data']['source']
def sendEmail(content):
	_user = "584070664@qq.com"
	_pwd  = "vvodyfespsvtbbab"
	_to   = getEmialAdress()
	localtime = time.strftime('%Y-%m-%d %H:%M',time.localtime(time.time()))

	msg = MIMEText(content,"html","utf-8")
	msg["Subject"] = Header("%s后台源监测报告"%localtime,"utf-8")
	msg["From"]    = "后台源监测"
	msg["To"]      = 'you'
	try:
		s = smtplib.SMTP_SSL("smtp.qq.com", 465)
		s.login(_user, _pwd)
		s.sendmail(_user,_to, msg.as_string())
		s.quit()
		print 'Success!'
	except smtplib.SMTPException,e:
		print "Falied,%s"%e 
def pullTsInfo(urllist,tsurl):
	isRe=tsurl.startswith("/")
	urlCount=len(urllist)
	resultUrl=""
	if not isRe:
		urllist[urlCount-1]=tsurl
		for x in urllist:
			resultUrl+=x+"/"
		resultUrl=resultUrl[:-1]
	else :
		for x in range(1,4):
			resultUrl+=urllist[x-1]+"/"
		resultUrl+=tsurl
	return resultUrl
def httppost():
	url="http://api.bj.1252524079.clb.myqcloud.com/cctvws/api/v1/live/room/getRoomList"
	data={"userId":"1501230094754","ownerID":"26","type":"2"}
	data_ul=urllib.urlencode(data)
	req=urllib2.Request(url,data_ul)
	res=urllib2.urlopen(req,timeout=5).read()
	print res
def checkAgain(urllist,db):
	for x in urllist:
		result=gettag(x,1)
		if result==True:
			try:
				cursor.execute("update t_channel_source set is_delete = 0,modifty_time=now() where source='%s'"%source)
				db.commit()
			except Exception as e:
				db.rollback()
			else:
				pass
			finally:
				pass
		print "验证结果：%s" %result
		print "********************************"
def getChannelName():
	db=MySQLdb.connect(dbIp,dbUser,dbPassWord,dbName,charset='utf8')
	cursor=db.cursor()
	for x in deathSource.keys():
		count=cursor.execute("select channel from t_channel where id=%s"%x)
		result=cursor.fetchone()
		deathSource[x].channelname=result
	for x in reviveSource.keys():
		count=cursor.execute("select channel from t_channel where id=%s"%x)
		result=cursor.fetchone()
		reviveSource[x].channelname=result
def creatEmailContent():
	content = "<html>"
	isNullDeath = len(deathSource)!=0
	isNullRevive = len(reviveSource)!=0
	if isNullDeath:
		content = content+"<h1>失效：</h1>"
		for x in deathSource.values():
			content = content + "<h2>%s：</h2>"%x.channelname
			for s in x.source:
				content = content + "<p>%s</p>"%s
	if isNullRevive:
		content = content+"<h1>复活：</h1>"
		for x in reviveSource.values():
			for s in x.source:
				content = content + "<h2>%s：</h2>"%x.channelname
				content = content + "<p>%s</p>"%s
	return content+"</html>"
def getEmialAdress():
	emails = []
	db=MySQLdb.connect(dbIp,dbUser,dbPassWord,dbName,charset='utf8')
	cursor=db.cursor()
	count=cursor.execute('select email from t_manager_email')
	adresses=cursor.fetchmany(count)
	for x in adresses:
		emails.append(x[0])
	return emails
if __name__ == '__main__':
	reload(sys)
	print "*************"
	sys.setdefaultencoding("utf-8")
	# res=gettag("http://m3u8-2.live.snrtv.com/sxbc/sxbc-nl/index.m3u8",1)
	# print res
	createConnect()
	for x in xrange(1,3):
		createDeathConnect()
	getChannelName()
	content = creatEmailContent()
	if len(deathSource)!=0 or len(reviveSource)!=0:
		sendEmail(content)
	# for x in changeId.values():
	# 	print x.channelname