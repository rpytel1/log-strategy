int f(int n) {
    if (n == 0) {
        return 1; 
    } else {
        return n * f(n-1);
    }
}
int fatal(int n) {
    if (n == 0) {
        return 1; 
    } else {
        return n * f(n-1);
    }
}
int babykiller(int n) {
    if (n == 0) {
        return 1; 
    } else {
        return n * f(n-1);
    }
}
