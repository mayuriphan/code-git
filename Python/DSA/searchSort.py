def binSearch(nums,n):
    l=0
    r=len(nums)-1
    # while l<=r:
    #     m=l+(r-l)//2
    #     print(nums[m])
    #     if nums[m]==n:
    #         return m
    #     elif n<nums[m]:
    #         r=m-1
    #     else:
    #         l=m+1
    # return None
    while l<=r:
        m=l+(r-l)//2
        if nums[m]==n:
            return m
        elif n<nums[m]:
            r=m-1
        else:
            l=m+1
    return None

def quickSort(nums):
        if len(nums)<=0:
            return nums
        else:
            p=nums.pop()
            s,l=[],[]
            for v in nums:
                if v<p:
                    s.append(v)
                else:
                    l.append(v)
        return quickSort(s)+[p] + quickSort(l)

# 12,3,4,5,2,1 7
def Tsum(nums,s):
    nums.sort()
    print(nums)
    res=[]
    for i in range(len(nums)-2):
        l=i+1
        r=len(nums)-1
        while l<r:
            cs=nums[i]+nums[l]+nums[r]
            if cs== s:
                res.append([nums[i],nums[l],nums[r]])
                l+=1
                r-=1
            elif cs<s:
                l+=1
            else:
                r-=1
    return res

print(Tsum([5,3,6,2,1,0],9))
# print(quickSort([5,3,6,2,1,0]))
# print(binSearch([1,2,3,4,5,6],0))
