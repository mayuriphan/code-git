def checkSetbit(num,dig):
    # to check bit OR with number
    if num & 1<<dig:
        print("bit set")
    else:
        print("bit not set")

def toggleBit(num,n):
    # XOR
    num^1<<n

def setBit(num,n):
    msg=num | 1<<n
    print(msg)

def unSetBit(num,n):
    if num & ~(1<<n):
        print("unset")

def binfunc(num):
    l=[]
    count=0
    while num>0:
        rem=num%2
        num=num//2
        # print(rem)
        l.append(rem)
        if rem==1:
            count+=1
    for val in l:
        if len(l)<4:
            l.append(0)
        else:
            break
    l=l[::-1]
    print(l,count)

# def countBit(num):

# checkSetbit(2,1)
# toggleBit(8,1)
# setBit(5,1)
binfunc(10)
