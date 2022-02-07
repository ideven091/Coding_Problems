console.log("Hi");

function fib(n){
    if(n <=2)
        return n;
    else{

        let a = 0, b = 1;
        for(let i=1;i<n;i++){
            b = a + b;
            a = b - a;
        }
        return b;
    }
}



console.log(fib(10));