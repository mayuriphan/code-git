#include <stdio.h>
int main(){
int count=0;
int spc=0;
char *stri="I am Panda";
int i=0;
while(stri[i]!='\0'){
    if(stri[i]!=' '){
        count++;
    }
    i++;
}
printf("%d",count);    
    
    
    
return 0;
}