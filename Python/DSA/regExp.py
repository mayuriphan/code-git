# regular exp
import re

with open("C:\\Users\\mphansalkar\\Documents\\test.txt.txt","r+") as f:
    fl=f.read()
    f1=(fl.split())
    f1=",".join(f1)
    print(f1)


# patrn=r'\d{3}[.-]\d{3}[.-]\d{3}[.-]\d{3}'
# patrn=r'def.*\n.*\n.*\n.*\n.*\n.*\n.*\(x\)'
patrn=r'def.+'

# print((fl))
li=re.findall(patrn,f1)
print(li)

# stri=" ".join(li[0])
# print(type(stri))

# with open("C:\\Users\\mphansalkar\\Documents\\test.txt.txt","a+") as f:
#     f.write('\n')
#     fl=f.write(stri)

strin="me and Your Sister!"

ptrn=r'[A-Z].* '
res=re.findall(ptrn,strin)
print(res)