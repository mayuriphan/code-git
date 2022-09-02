import threading
i=0
l=threading.Lock()
def workWithThreads():
    global i
    # l.acquire()
    i+=1
    # l.release()
    



t1=threading.Thread(target=workWithThreads)
t1.start()
t2=threading.Thread(target=workWithThreads)
t2.start()
t1.join()
t2.join()
print(i)