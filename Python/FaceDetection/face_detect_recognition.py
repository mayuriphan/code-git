import cv2
import numpy as np
import face_recognition as fr
  
''' This program compares a known picture with webcam input. If the webcam input matches the known picture
 then assigned name of known picture is displayed on frame and in all other cases "new_img" is displayed on frame.
'''
# capture picture/video from webcam
wbcam = cv2.VideoCapture(0) 
# load known picture to compare with webcam's input
img = fr.load_image_file("emmaW.jpg")
# encode the known picture
img_encoding = fr.face_encodings(img)[0]
known_encoding = [img_encoding]
# give name to the known picture
k_name = ["EmmaWatson"]


while True: 
    rectangl,fram = wbcam.read()
    rgb_fram = fram[:,:,::-1]
    face_loc = fr.face_locations(rgb_fram)
    face_encode = fr.face_encodings(rgb_fram,face_loc)

# chk line 
    for (top, right, bottom, left), face_encoding in zip(face_loc,face_encode):
        print(top, right, bottom, left)
        mtch = fr.compare_faces(known_encoding,face_encoding)
        name = "new_img"
        face_dist = fr.face_distance(known_encoding,face_encoding)
        match_i = np.argmin(face_dist)
        if mtch[match_i]:
            name = k_name[match_i]
        cv2.rectangle(fram,(left,top),(right,bottom),(0,0,255),2)
        cv2.rectangle(fram,(left,bottom -35),(right,bottom),(0,0,255),cv2.FILLED)
        fnt = cv2.FONT_HERSHEY_SIMPLEX
        cv2.putText(fram,name,(left+6,bottom-6),fnt,1.0,(255,255,255),1)
      
    cv2.imshow('Detecting Faces', fram)
    if cv2.waitKey(1) & 0xFF == 'q':
        break
wbcam.release()
cv2.destroyAllWindows()