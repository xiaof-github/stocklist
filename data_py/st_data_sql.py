# coding=utf-8
import st_data_pull
import sqlalchemy

name = "high_limit"
engine = sqlalchemy.create_engine('mysql://root:123456@127.0.0.1/stock?charset=utf8')

#存入数据库
df = st_data_pull.get_rise_top_today_all()
today = st_data_pull.today()
df.to_sql(name,engine, if_exists='append')