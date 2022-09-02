def longSubString(s):
    # s=s.lstrip()
    ns=[]
    for ele in s:    
        if ele in ns:
            ns=ns[ns.index(ele)+1:]
        ns.append(ele)
    return ns

def moveZero(arr):
    i=count=0 
    while count<len(arr):
        if arr[i]==0:
            arr.append(arr.pop(i))  
        else: i+=1
        count+=1
    return arr

nums={'I':1,"V":5,"X":10,"L":50,"C":100,"D":500,"M":1000}
def romToInt(s):

    i=tot=0
    while i<len(s):
        if i+1 < len(s) and nums[s[i]]<nums[s[i+1]]:
            print("if")
            tot+=nums[s[i+1]]-nums[s[i]]
            i+=2
            
        else:
            print("else")
            tot+=nums[s[i]]
            i+=1
        print(tot)
    return tot
        
        

def recDup(arr,i):
    print(arr[i],arr[i+1])
    # i=0    
    if arr[i]==arr[i+1]:
        arr.pop(arr[i+1])  
        recDup(arr,i+1)    
    else:
        recDup(arr,i+1)
    return arr

print(recDup([1,1,4,5,5],0))



print(romToInt("VII"))
print(moveZero([0,2,3,0,3,5]))
print(longSubString("mamusshima"))

arr=[1,2,3,4,2,5]

print(arr[1:])