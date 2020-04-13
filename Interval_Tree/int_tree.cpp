#include <iostream>
using namespace std;

struct Interval{
    int low, high;
};

struct ITNode
{
    Interval *i;
    int max;
    ITNode *left, *right;
};

ITNode *newNode(Interval i){
    ITNode *temp = new ITNode;
    temp->i = new Interval(i);
    temp->max = i.high;
    temp->left = temp->right = NULL;
}

ITNode *insert(ITNode *root, Interval i){
    if(root == NULL){
        return newNode(i);
    }
    int l = root->i->low;

    if(i.low < l){
        root->left = insert(root->left, i);
    } else {
        root->right = insert(root->right, i);
    }

    if(root->max < i.high){
        root->max = i.high;
    }

    return root;
}

bool doOverlap(Interval i1, Interval i2){
    if(i1.low <= i2.high && i2.low <= i1.high){
        return true;
    }
    return false;
}

Interval *overlapSearch(ITNode *root, Interval i) 
{ 
    // Base Case, tree is empty 
    if (root == NULL) return NULL; 
  
    // If given interval overlaps with root 
    if (doOverlap(*(root->i), i)) 
        return root->i; 
  
    // If left child of root is present and max of left child is 
    // greater than or equal to given interval, then i may 
    // overlap with an interval is left subtree 
    if (root->left != NULL && root->left->max >= i.low) 
        return overlapSearch(root->left, i); 
  
    // Else interval can only overlap with right subtree 
    return overlapSearch(root->right, i); 
} 

void inorder(ITNode *root) 
{ 
    if (root == NULL) return; 
  
    inorder(root->left); 
  
    cout << "[" << root->i->low << ", " << root->i->high << "]"
         << " max = " << root->max << endl; 
  
    inorder(root->right); 
} 

int main() 
{ 
    // Let us create interval tree shown in above figure 
    Interval ints[] = {{70, 89}, {75, 76}, {71, 92}, 
        {37, 50}, {83, 88}, {50, 60}, {65,84}, {74, 99} 
    }; 
    int n = sizeof(ints)/sizeof(ints[0]); 
    ITNode *root = NULL; 
    for (int i = 0; i < n; i++) 
        root = insert(root, ints[i]); 
  
    cout << "Inorder traversal of constructed Interval Tree is\n"; 
    inorder(root); 
  
    Interval x = {90, 91}; 
    Interval y = {48, 68};
    cout << "\nSearching for interval [" << x.low << "," << x.high << "]"; 
    Interval *res = overlapSearch(root, x); 
    if (res == NULL) 
        cout << "\nNo Overlapping Interval\n"; 
    else
        cout << "\nOverlaps with [" << res->low << ", " << res->high << "]\n"; 
    
    cout << "\nSearching for interval [" << x.low << "," << x.high << "]"; 
    Interval *res1 = overlapSearch(root, y); 
    if (res1 == NULL) 
        cout << "\nNo Overlapping Interval\n"; 
    else
        cout << "\nOverlaps with [" << res1->low << ", " << res1->high << "]\n"; 
    return 0; 
} 


