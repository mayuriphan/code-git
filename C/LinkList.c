

#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node* link;
};

struct Node* create_LL();

void disp(struct Node * root);

int main()
{
    printf("Link List:\n");
    struct Node* Root=NULL;
    Root=create_LL();
    disp(Root);
    
    
    return 0;
}

struct Node* create_LL()
{
    struct Node* root=NULL;
    struct Node* p=NULL;
    struct Node* temp=NULL;
    
    
    
    for(int i=0;i<5;i++){
        
        temp=(struct Node*)malloc(sizeof(struct Node));
        printf("enter the node %d:",i+1);
        scanf("%d",&(temp->data));
        temp->link=NULL;
        
    
        if(root == NULL){
            root=temp;
        
        }
    
        else{
            p=root;
            while(p->link!=NULL)
                p=p->link;
                p->link=temp;
            
        
        }
    }
        
    return root;
}

void display(struct Node * root){
    struct Node* p=root;
    
    while(p->link!=NULL){
        printf("%d->",p->data);
        p=p->link;
    }
}    

