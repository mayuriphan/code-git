l=[1,2,3]
i=0
j=len(l)-1
while i<=j:
    temp=l[i]
    l[i]=l[j]
    l[j]=temp
    i+=1
    j-=1
print(l)

from dsQueStack import stack
s="A little girl !"
st=stack()
strn=""
for i in range(0,len(s)):
    st.push(s[i])

while not st.isempty():
    strn+=st.pop()

print(strn)
    
