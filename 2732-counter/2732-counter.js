/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    let num = n-1;
    return function() {
        return ++num;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */