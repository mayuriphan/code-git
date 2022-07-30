#include <stdio.h>

int main()
{
    printf("Binary Search:");
    
  
    int srch=5;
    int lo=0;
    int mid;
    int flag=0;
    int a[]={1,2,3,5};
    int hi=sizeof(a)/sizeof(a[0]);
    
    
    while(lo<=hi){
        mid=(lo+hi)/2;
        
        if (srch==a[mid]){
            
           flag=1;
           break;
        }
        if(srch<a[mid]){
            hi=mid-1;
        }
        else
            lo=mid+1;
    }
    
    if (flag==1){
        printf("Found number at: %d",mid);
    }    
    
    else
        printf("Not Found");
    
    
    
    return 0;
}