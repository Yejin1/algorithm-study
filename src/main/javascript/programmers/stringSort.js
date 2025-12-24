
// 프로그래머스
// 문자열 내 마음대로 정렬하기
// 유형 : 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/12915?language=javascript



function solution(strings, n) {

    strings.sort(function(a,b){
        var c1 = a[n];
        var c2 = b[n];


        if(c1 === c2) return a.localeCompare(b);
        return c1.localeCompare(c2);
    });


    return strings;
}