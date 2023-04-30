import sys

import pjsua as p

import threading

import time



# Method to print Log of callback class
class LogConfig:
    def log_cb(level, str, len):
        print(str),



# AccountCallback is the class to receive notifications of Account's events

class AccountCallback(p.AccountCallback):

    def __init__(self, acc):

        p.AccountCallback.__init__(self, acc)

    def on_reg_state(self):
        p.AccountCallback.on_reg_state(self)



# CallCallback is the class to receive notifications from call events.

class CallCallback(p.CallCallback):

    def __init__(self, call=None):

        p.CallCallback.__init__(self, call)

    

    

    def on_state(self):

        print("Call is :", self.call.info().state_text),
        print("Call-ID: ", self.call.info().sip_call_id),

        print("last code :", self.call.info().last_code),

        print("(" + self.call.info().last_reason + ")")
        print("Call duration in secs: ", self.call.info().total_time)

        

    # This is the notification when call's media state is changed

    def on_media_state(self):

        global lib

        if self.call.info().media_state == p.MediaState.ACTIVE:

            # Connect the call to sound device

            call_slot = self.call.info().conf_slot

            lib.conf_connect(call_slot, 0)

            lib.conf_connect(0, call_slot)

            print("Hey !!!!! Hope you are doing GOOD !!!!!!!!!!")

            print (lib)


# Lets start our main loop here

try:

    # Start of the Main Class

    # Create library instance of Lib class

    lib = p.Lib()



    # Instantiate library with default config

    lib.init(log_cfg = p.LogConfig(level=3, callback=log_cb))



    # Configuring one Transport Object and setting it to listen at 5060 port and UDP protocol

    trans_conf = p.TransportConfig()

    print "-------------------------Now Registration Process will Begin----------------------\n\n"

    trans_conf.port = 5060       # 5060 is default port for SIP

    a=raw_input("Please Enter the IP address of the Client: ")
    print "Using the default port number for SIP: 5060"

    trans_conf.bound_addr = a

    transport = lib.create_transport(p.TransportType.UDP,trans_conf)



    # Starting the instance of Lib class

    lib.start()

    lib.set_null_snd_dev()



    # Configuring Account class to register with Registrar server

    # Giving information to create header of REGISTER SIP message

    

    ab4=raw_input("Enter IP address of the Server: ")
    ab=raw_input("Enter Username: ")
    ab1=raw_input("Enter Password: ")
    ab2=raw_input("Do you want to use the display name same as the username  Y/N ??")
    if ab2=="y" or ab2=="Y":
        ab3=ab
    else:
        ab3=raw_input("Enter Display Name: ")

    acc_conf = p.AccountConfig(domain = ab4, username = ab, password =ab1, display = ab3)

                              # registrar = 'sip:'+ab4+':5060', proxy = 'sip:'+ab4+':5060')

    acc_conf.id ="sip:"+ab

    acc_conf.reg_uri ='sip:'+ab4+':5060'

    acc_callback = MyAccountCallback(acc_conf)

    acc = lib.create_account(acc_conf,cb=acc_callback)



    # creating instance of AccountCallback class

    acc.set_callback(acc_callback)


    print "\nRegistration Complete-----------"
    print('Status= ',acc.info().reg_status, \

         '(' + acc.info().reg_reason + ')')



    ab5=raw_input("Do you want to make a call right now ??   Y/N\n")
    print "\n"

    if ab5=="y" or ab5=="Y":

    # Starting Calling process.
        b=raw_input("Enter the destination URI: ")

        call = acc.make_call(b, CallCallback())

        

        

        # Waiting Client side for ENTER command to exit

        print('Press <ENTER> to exit and destroy library')

        input = sys.stdin.readline().rstrip('\r\n')



        # We're done, shutdown the library

        lib.destroy()

        lib = None

    else:

        print" Unregistering ---------------------------"
        time.sleep(2)
        print "Destroying Libraries --------------"
        time.sleep(2)
        lib.destroy()
        lib = None
        sys.exit(1)


except p.Error, e:

    print("Exception: " + str(e))

    lib.destroy()

    lib = None

    sys.exit(1)
