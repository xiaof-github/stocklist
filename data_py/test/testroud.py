# coding=utf-8
from decimal import *
# getcontext().rounding = ROUND_HALF_UP
# getcontext().prec = 4
print(getcontext())
a = Decimal("104.850")
b = Decimal("0.9")
c = 94.365
d = "94.365"
print(Decimal(str(c)).quantize(Decimal('1.00'), rounding=ROUND_HALF_UP))
print(Decimal(d).quantize(Decimal('1.00'), rounding=ROUND_HALF_UP))
print(a*b)
print(round((104.850*0.9),2))
print(float(a*b))