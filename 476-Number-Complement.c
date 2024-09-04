int findComplement(int num) {
    int complement = 0;
    unsigned int power = 1;  

    while(num > 0) {
        complement += (num % 2 == 0) ? power : 0;
        num /= 2;
        power *= 2;
    }

    return complement;
}
