from sqlalchemy import create_engine
import tushare as ts

#df = ts.get_tick_data('600848', date='2014-12-22')
ts.get_hist_data('600848',start='2015-01-05',end='2015-01-09')
#engine = create_engine('mysql://root:123456@127.0.0.1/stock?charset=utf8')

#存入数据库
#df.to_sql('his_data',engine)