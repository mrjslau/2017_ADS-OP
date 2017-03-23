//
//  main.c
//  Deque
//
//  Created by Marijus Laucevicius on 08/03/2017.
//  Copyright © 2017 Marijus Laucevicius. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include "DequeMarijus.h"

int main() {
    
    Deque deque = NULL;
    int answer, option = 0;
    ADT newValue;
    ADT * searchValue = malloc(sizeof(ADT));
    ADT * storeInt = malloc(sizeof(ADT));
    char string[256];
    char *ptr;
    long check;
    
    info();
    while (option < 12 && option > -1) {
        scanf("%d", &option);
        
        switch(option) {
            case 0:
                info();
                break;
            case 1:
                answer = create(&deque);
                if (answer == 1) {
                    printf("Dekas sekmingai sukurtas \n");
                }
                else printf("Klaida. Dekas nesukurtas \n");
                break;
            case 2:
                answer = empty(deque);
                if (answer == 2) printf("Dekas turi elementu \n");
                else if(answer == 1) printf("Dekas dar nesukurtas \n");
                else printf("Dekas tuscias \n");
                break;
                
            case 3:
                if (empty(deque) == 1)
                {
                    printf("Dekas dar nesukurtas \n");
                    break;
                }
                printf("Iveskite norima ideti elementa \n");
                
                scanf("%s", string);
                check = strtol(string, &ptr, 0);
                if(check != 0 && check < 2147483647 && check > -2147483648)
                {
                    newValue = check;
                }
                else
                {
                    printf("Klaida. Per didelis skaicius");
                    break;
                }
                
                answer = insertTop(deque, newValue);
                if (answer == 1) {
                    printf("Elementas idetas \n");
                }
                else printf("Klaida. Dekas dar nesukurtas \n");
                break;
            case 4:
                answer = removeTop(deque);
                if (answer == 1) {
                    printf("Deko pirmas el. istrintas \n");
                }
                else printf("Klaida. Dekas tuscias/nesukurtas \n");
                break;
            case 5:
                if (empty(deque) == 1)
                {
                    printf("Dekas dar nesukurtas \n");
                    break;
                }
                printf("Iveskite norima ideti elementa \n");
                
                scanf("%s", string);
                check = strtol(string, &ptr, 0);
                if(check != 0 && check < 2147483647 && check > -2147483648)
                {
                    newValue = check;
                }
                else
                {
                    printf("Klaida. Per didelis skaicius");
                    break;
                }
                
                answer = insertBottom(deque, newValue);
                if (answer == 1) {
                    printf("Elementas idetas \n");
                }
                else printf("Klaida. Dekas dar nesukurtas \n");
                break;
            case 6:
                answer = removeTop(deque);
                if (answer == 1) {
                    printf("Deko paskutinis el. istrintas \n");
                }
                else printf("Klaida. Dekas tuscias/nesukurtas \n");
                break;
            case 7:
                answer = firstElement(deque, storeInt);
                if (answer != 0) {
                    printf("%d \n", *storeInt);
                }
                else printf("Dekas tuscias/nesukurtas \n");
                break;
            case 8:
                answer = lastElement(deque, storeInt);
                if (answer != 0) {
                    printf("%d \n", *storeInt);
                }
                else printf("Dekas tuscias/nesukurtas \n");
                break;
            case 9:
                answer = count(deque);
                if (answer != 0) {
                    printf("Elementu kiekis deke = %d \n", answer);
                }
                else printf("Dekas tuscias/nesukurtas \n");
                break;
            case 10:
                answer = deleteDeck(&deque);
                if (answer != 0) {
                    printf("Dekas sunaikintas \n");
                }
                else printf("Dekas nesukurtas \n");
                break;
            case 11:
                printf("Iveskite ieskoma elementa \n");
                scanf("%d", searchValue);
                answer = search(deque, searchValue);
                if (answer != 0) {
                    printf("Ieskomo elemento egzemplioriu deke = %d \n", *searchValue);
                }
                else printf("Dekas tuscias/nesukurtas \n");
                break;
                
            default:
                printf("\n Neteisingas pasirinkimas.\n \n");
                option = 0;
                info();
                break;
        }
    }

    return 0;
}
