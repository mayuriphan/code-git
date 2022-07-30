class stack():
    def __init__(self):
        self.st_list=[]

    def push(self,num):
       return self.st_list.append(num)

    def pop(self):
        if len(self.st_list)>0:
            return self.st_list.pop()
        else:
            None
    
    def isempty(self):
        return self.st_list==[]

    def peek(self):
        if len(self.st_list)>0:
            return self.st_list[-1]

    def trav(self):
        return self.st_list

class Q():
    def __init__(self):
        self.q_lis=[]

    def push(self,num):
        return self.q_lis.append(num)

    def pop(self):
        if len(self.q_lis)>0:
            # print(self.q_lis[0])
            return self.q_lis.pop(0)
    
    def dupli(self):
        try:
            if len(self.q_lis)>0:
                self.dup_lis=[]
                for i in range (0,len(self.q_lis)):
                    if self.q_lis[i] in self.dup_lis:
                        self.q_lis.pop(i)
                    else:
                        self.dup_lis.append(self.q_lis[i])
        except Exception as e:
            print(str(e))

            
    def trav(self):
        return self.q_lis
    
q=Q()
print(q.push(8))
print(q.push(2))
print(q.push(6))
print(q.trav())        
print(q.pop())
# print(q.pop())
print(q.trav()) 
print(q.push(8)) 
print(q.push(8))
print(q.push(1))
q.dupli()
print(q.trav())      

# s=stack()
# s.push(8)
# s.push(4)
# s.push(5)
# s.push(3)
# print(s.trav())
# s.pop()
# print(s.peek())