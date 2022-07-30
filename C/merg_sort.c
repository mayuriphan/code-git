

#include <stdio.h>

void merg(int a[],int s,int e){
    int i=s;
    int k=s;
    int mid=(s+e)/2;
    int j=mid+1;
    int temp[10];
    
    
    while(i<=mid && j<=e ){
        if(a[i]<a[j]){
            temp[k++]=a[i++];
        }
        else{
            temp[k++]=a[j++];
        }
        
    }
    while(i<=mid ){
        temp[k++]=a[i++];
     }
    while(j<=e ){
        temp[k++]=a[j++];
     }
   
     
     for(int i=0;i<=e;i++){
         a[i]=temp[i];
     }
}

void mer_so(int b[],int s,int e){
    int mid=(s+e)/2;
    if(s>=e){ 
        return 0;
            }
    mer_so(b,s,mid);
    mer_so(b,mid+1,e);
    merg(b,s,e);
}

int main()
{
    printf("Merge Sort: ");
    int a[5]={1,8,7,4,2};
    int n=sizeof(a)/sizeof(int);
    int st=0;
    int en=n-1;
    mer_so(a,st,en);
    for(int i=0;i<=n-1;i++){
        printf("%d",a[i]);
    }

    return 0;
}
