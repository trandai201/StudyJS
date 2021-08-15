// temp.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"


int UCLN(int a,int b){
	int r = 0;
	while(a % b != 0){
		r = a % b;
		a = b;
		b = r;
	}
	return b;
}



int _tmain(int argc, _TCHAR* argv[])
{
	printf("%d",UCLN(5,3));

	scanf("%d");
	return 0;
}

