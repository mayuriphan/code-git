#  head
#   |
#   v 
# A|NXT --> B|NXT --> C|NULL

# class Node():
#     def __init__(self,data):
#         self.data= data
#         self.nxt=None
        

# class LinkList():
#     def __init__(self):
#         self.head=None
        
#     def append(self,data):
#         apndNode=Node(data)
#         if self.head == None:
#             self.head=apndNode
#             return
#         else:
#             lastNode=self.head
#             while lastNode.nxt:
#                 lastNode=lastNode.nxt                
#             lastNode.nxt=apndNode            

#     def deleteNode(self,data):
#         if self.head==None:
#             print("Empty List")
#             return
#         currNode=self.head   
#         while currNode.nxt:
#             print("curr node:",currNode.data)
#             print("nxt:",currNode.nxt.data)
#             if currNode.data==data:
#                 self.head=currNode.nxt
#                 currNode=None
#                 print("First node deleted")
#                 return
#             elif currNode.nxt.data == data:
#                 currNode.nxt=currNode.nxt.nxt                
#                 return
#             else:      
#                 currNode=currNode.nxt
        
       
#     def travList(self):        
#         if self.head==None:
#             print("Empty List")
#             return
#         else:
#             curNode=self.head
#             while curNode:
#                 print(curNode.data)
#                 curNode=curNode.nxt
                
# practice LL

class Node():
    def __init__(self,data):
        self.data=data
        self.nxt=None
    
class LinkList():
    def __init__(self):
        self.head=None

    def append(self,data):
        apndNode=Node(data)
        if self.head==None:
            self.head=apndNode
            return
        lastNode=self.head
        while lastNode.nxt:
            lastNode=lastNode.nxt
        lastNode.nxt=apndNode
    
    def travList(self):
        curNode=self.head
        while curNode:
            print(curNode.data)
            curNode=curNode.nxt
    
    def deleteNode(self,data):
        curNode=self.head
        while curNode:
            if curNode.data == data:
                self.head=curNode.nxt
                curNode=None
            elif curNode.nxt.data == data:
                curNode.nxt=curNode.nxt.nxt
                return
            else:
                curNode=curNode.nxt
    
    def prepend(self,d1,d2):
        pNode=Node(d2)
        if self.head==None:
            self.head=pNode
            return
        curNode=self.head
        while curNode.nxt:
            if curNode.data ==  d1:
                pNode.nxt=curNode
                self.head=pNode
                return
            elif curNode.nxt.data==d1:
                pNode.nxt=curNode.nxt
                curNode.nxt=pNode
                return
            else:
                curNode=curNode.nxt
    
    def revList(self):
        prev=None
        curNode=self.head
        while curNode:
            nxt=curNode.nxt
            curNode.nxt=prev
            prev=curNode
            curNode=nxt
        self.head=prev

    def dups(self):
        dup={}
        curNode=self.head
        
        # print(i)
        while curNode:
            if curNode.data in dup:
                i=dup[curNode.data]+1
                dup[curNode.data]=i
            else:                
                dup[curNode.data]=1
            print(dup)
            curNode=curNode.nxt

    def checkLoop(self):
        s=f=self.head
        while(s and f and f.nxt):
            s=s.nxt
            f=f.nxt.nxt
            if s==f:                
                return print("Loop")
        print("No loop")

ll=LinkList()
ll.append("A")
ll.append("B")
ll.append("C")
ll.append("D")
ll.travList()
print("-------")
# ll.deleteNode("A")
# ll.prepend("B","J")
# print("-------")
# ll.prepend("B","A")
# ll.append("D")
# ll.append("B")
# print("-------")
# ll.travList()
# ll.dups()
# ll.revList()
# print("-------")
# ll.travList()
# ll.head.nxt.nxt.nxt=ll.head.nxt
# ll.travList()
ll.checkLoop()