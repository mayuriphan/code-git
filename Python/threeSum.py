
def threeNumberSum(array, targetSum):
    # Write your code here.
    res=[]
    array.sort()
    for i in range(len(array)-2):
        cS=array[i]
        left=i+1
        right=len(array)-1
        while left<right:
            cs=array[i]+array[left]+array[right]
            if cs==targetSum:
                res.append([array[i],array[left],array[right]])
                left+=1
                right-=1
            elif cs<targetSum:
                left+=1
            elif cs>targetSum:
                right-=1
    return res

def twoSum(array,targetSum):
# Write your code here.
    res=[]
    array.sort()
    # for i in range(len(array)):        
    left=0
    right=len(array)-1
    while left<right:
        cs=array[left]+array[right]
        if cs==targetSum:
            res.append([array[left],array[right]])
            left+=1
            right-=1
        elif cs<targetSum:
            left+=1
        elif cs>targetSum:
            right-=1
    return res

def dups(ar):   
    ar_d=set() 
    i=0
    for val in ar:   
        if val in ar_d:      
            return val
        ar_d.add(val)
        
    return -1

print(dups([1,2,7,9,7]))


print(threeNumberSum([1,0,-9,8,-1],10))
print(twoSum([1,2,4,5,8],10))




		
