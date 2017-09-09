# coding=utf-8
import st_data_pull
import sqlalchemy
from sqlalchemy.orm import sessionmaker
from sqlalchemy import func
import MySQLdb
import pandas as pd


name = "high_limit"
engine = sqlalchemy.create_engine('mysql://root:123456@127.0.0.1/stock?charset=utf8')

#获取起始index
Session = sessionmaker(bind=engine)
session = Session()
session.execute('use stock')
r = session.execute('select count(*) from high_limit').fetchall()
print r[0][0]
start = r[0][0]
#print(session.query(high_limit).all())
session.close()


#存入数据库
df = st_data_pull.get_high_limit_today_all()
index = df.index.values
#print(index)
new_index = [i+start for i in index]
#print(new_index)
df.index = new_index
#print(df)
df.to_sql(name,engine, if_exists='append')





# # 打开数据库连接
# db = MySQLdb.connect(host='localhost',user='root',passwd='123456',db='stock',port=3306)
#
# # 使用cursor()方法获取操作游标
# cursor = db.cursor()
# cursor.execute("set names utf8")
# cursor.execute("use stock")
# #创建数据表SQL语句
# sql = """ select * from high_limit """
# cursor.execute(sql)
# data = cursor.fetchall()
# print cursor.rowcount
## try:
#     # 执行SQL语句
#     cursor.execute(sql)
#     # 获取所有记录列表
#     results = cursor.fetchall()
#     for row in results:
#         index = row[0]
#         date = row[1]
#         code = row[2]
#         name = row[3]
#         pre_close = row[4]
#         price = row[5]
#         high = row[6]
#         low = row[7]
#         volume = row[8]
#         amount = row[9]
#         time = row[10]
#         high_limit = row[11]
#
#         # 打印结果
#         print "index=%d,date=%s,code=%d,name=%s,pre_close=%f,price=%f,high=%f,low=%f,volume=%f,amount=%f,time=%s,high_limit=%f" % \
#             (index, date, code, name, pre_close, price, high, low, volume, amount, time, high_limit )
# except:
#    print "Error: unable to fecth data"

# 关闭数据库连接
#db.close()