//
//  Deque.h
//  Deque
//
//  Created by Marijus Laucevicius on 08/03/2017.
//  Copyright © 2017 Marijus Laucevicius. All rights reserved.
//
//  ADT DEKAS su sukūrimo, sunaikinimo, elemento idėjimo,
//  ištrynimo, elemento gavimo, bet elementų kiekio gavimo
//  operacijomis.
//
//  int Funkcijos grąžina reikšmes nurodančias ar pavyko atlikti
//  operacijas


#define ADT int

typedef struct Node{
    ADT value;
    struct Node* next;
}* Node;

typedef struct Deque{
    struct Node *head;
}* Deque;

void info();
int create(Deque *deque);
//0 - klaida, 1 - pavyko sukurt
int empty(Deque deque);
//0 - tuscia 1 - nesukurtas, 2 - turi elementu
int insertTop(Deque deque, ADT newValue);
//0 - nesukurtas dekas, 1 - pavyko ideti
int removeTop(Deque deque);
//0 - nesukurtas/tuscias dekas, 1 - pavyko istrinti
int insertBottom(Deque deque, ADT newValue);
//0 - nesukurtas dekas, 1 - pavyko ideti
int removeBottom(Deque deque);
//0 - nesukurtas/tuscias dekas, 1 - pavyko istrinti
int firstElement(Deque deque, ADT *storeValue);
//0 - nesukurtas/tuscias dekas, 1 - iraso elementa i kintamaji
int lastElement(Deque deque, ADT *storeValue);
//0 - nesukurtas/tuscias dekas, 1 - iraso elementa i kintamaji
int count(Deque deque);
//0 - nesukurtas/tuscias dekas, 1,2,3.... - elementu kiekis
int deleteDeck(Deque *deque);
//0 - nesukurtas dekas, 1 - pavyko istrinti
int search(Deque deque, ADT *searchValue);
//0 - nesukurtas/tuscias dekas, 1 - pavyko rasti atsakyma
