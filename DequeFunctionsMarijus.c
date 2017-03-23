//
//  DequeFunctions.c
//  Deque
//
//  Created by Marijus Laucevicius on 08/03/2017.
//  Copyright © 2017 Marijus Laucevicius. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include "DequeMarijus.h"

void info()
{
    printf("Pasirinkite norimą veiksmą:\n 0 - Info \n 1 - Sukurti tuščią deką,\n 2 - Patikrinti ar dekas tuščias \n 3 - Įdėti naują elementą į deko pradžią,\n 4 - Ištrinti elementą deko pradžioje,\n 5 - Įdėti naują elementą į deko pabaigą,\n 6 - Ištrinti elementą deko pabaigoje,\n 7 - Gauti deko pradžios elemento info,\n 8 - Gauti deko pabaigos elemento info,\n 9 - Gauti deko elementų skaičių,\n 10 - Sunaikinti deką,\n 11 - Elemento egzemplioriu kiekis deke. \n");
}

int create(Deque *deque)
{
    (*deque) = (Deque) malloc(sizeof(Deque));
    if (*deque == NULL) return 0;
    
    (*deque)->head = NULL;
    return 1;
}

int empty(Deque deque)
{
    if (deque == NULL)
        return 1;
    if (deque->head == NULL)
        return 0;
    
    return 2;
}

int insertTop(Deque deque, ADT newValue)
{
    if (deque == NULL) return 0;
    
    Node temp = (Node) malloc(sizeof(Node));
    
    temp->value = newValue;
    if(deque->head == NULL)
    {
        temp->next = NULL;
        deque->head = temp;
    }
    else
    {
        temp->next = deque->head;
        deque->head = temp;
    }
    return 1;
}

int removeTop(Deque deque)
{
    if (deque == NULL)
        return 0;
    if (deque->head == NULL)
        return 0;
    
    Node temp = deque->head;
    deque->head = temp->next;
    free(temp);
    return 1;
}

int insertBottom(Deque deque, ADT newValue)
{
    if (deque == NULL)
        return 0;
    
    Node temp = (Node) malloc(sizeof(Node));
    
    temp->value = newValue;
    temp->next = NULL;
    if	(deque->head == NULL)
        deque->head = temp;
    else
    {
        Node temp2 = deque->head;
        while (temp2->next != NULL)
            temp2 = temp2->next;
        
        temp2->next = temp;
    }
    return 1;
}

int removeBottom(Deque deque)
{
    if (deque == NULL)
        return 0;
    if (deque->head == NULL)
        return 0;
    
    Node temp = deque->head;
    if (temp->next == NULL)
    {
        deque->head = NULL;
        free(temp);
    }
    else
    {
        while (temp->next->next != NULL)
        {
            temp = temp->next;
        }
        free(temp->next);
        temp->next = NULL;
    }
    return 1;
}

int firstElement(Deque deque, int *storeValue)
{
    if (deque == NULL)
        return 0;
    if (deque->head == NULL)
        return 0;
    
    Node temp = deque->head;
    *storeValue = temp->value;
    return 1;
}

int lastElement(Deque deque, int *storeValue)
{
    if (deque == NULL)
        return 0;
    if (deque->head == NULL)
        return 0;
    
    Node temp = deque->head;
    while (temp->next != NULL)
        temp = temp->next;
    
    *storeValue = temp->value;
    return 1;
}



int count(Deque deque)
{
    if (deque == NULL)
        return 0;
    int count = 0;
    Node temp = deque->head;
    while (temp != NULL)
    {
        temp = temp->next;
        count++;
    }
    return count;
}

int deleteDeck(Deque *deque)
{
    if ((*deque) == NULL)
        return 0;
    if ((*deque)->head == NULL)
    {
        free((*deque));
        (*deque) = NULL;
    }
    else
    {
        Node temp = NULL;
        while ((*deque)->head != NULL)
        {
            temp = (*deque)->head;
            (*deque)->head = temp->next;
            free(temp);
        }
        free((*deque));
        (*deque) = NULL;
    }
    return 1;
}

int search(Deque deque, ADT *searchValue)
{
    if (deque == NULL)
        return 0;
    if (deque->head == NULL)
        return 0;
    
    int counter = 0;
    Node temp = deque->head;
    while (temp != NULL)
    {
        if(temp->value == *searchValue) counter++;
        temp = temp->next;
    }
    
    *searchValue = counter;
    
    return 1;
}
