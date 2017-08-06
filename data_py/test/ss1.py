from sqlalchemy import create_engine
import tushare as ts

df = ts.get_k_data('600000',start='2017-01-01')
print type(df)

#engine = create_engine('mysql://root:123456@127.0.0.1/stock?charset=utf8')
#df.to_sql('600000',engine)