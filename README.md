

## JavaScript Rhinoceros ##


> Chapter 4.

4.4 프로퍼티 접근 표현식

> 객체선언
> 
    var o = { x : 1 , y : { z :3 }, "a" : 4};
    var a = [o, 4 , [5, 6]];

> 접근 예제
>
>     log(o);		//Object {x: 1, y: Object, a: 4}
    log(o.x);	//1
    log(o.a); 	//4
    // log(o."a"); 	// unexpect string
    log(o[x]); 	// undefind.
    log(o["x"]); //1
    log(a[2]["1"]);  //6
    log(a[2][1]); // same. 6
    log("toString --> "+a[1].toString());
    log("valueOf --> "+a[1].valueOf());	
    log(a[0].x); // 1
    log(a[1].x); //undefind.
    
	

> 프로퍼티에는 var 하지않고 바로 생성 및 할당이 가능하다.
>  

Q. 자바스크립트는 객체 variable 에 접근가능한가?
