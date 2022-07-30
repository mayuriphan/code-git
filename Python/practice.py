class Node():
    def __init__(self,data):
        self.data=data
        self.nxt=None

class LL():
    def __init__(self):
        self.head=None
    def append(self,data):
        lastN=Node(data)
        if self.head==None:
            self.head=lastN
            return
        curN=self.head
        while curN.nxt:
            curN=curN.nxt
        curN.nxt=lastN
    
    def travL(self):
        curN=self.head
        while curN:
            print(curN.data)
            curN=curN.nxt
    
    def prepend(self,d1,d2):
        apN=Node(d2)
        if self.head==None:
            self.head=apN
            return
        curN=self.head
        prev=None
        while curN.nxt:
            if curN.data== d1:
                apN.nxt=curN
                self.head=apN
                return
            # a e   bc be
            elif curN.nxt.data==d1:
                apN.nxt=curN.nxt
                curN.nxt=apN
                return
            else:
                curN=curN.nxt



        



l1=LL()
l1.append(1)
l1.append(2)
l1.append(3)
# l1.travL()
l1.prepend(2,5)
l1.travL()