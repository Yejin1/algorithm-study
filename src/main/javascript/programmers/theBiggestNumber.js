

// 프로그래머스
// 가장 큰 수
// 유형 : 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/42746



function solution(numbers) {
    var answer = '';

    var strs = numbers.map((n) => String(n));


    strs.sort((a, b) => (b + a).localeCompare(a + b));
    if (strs[0] === "0") return "0";


    strs.forEach((s)=> {
        answer += s
    });

    return answer;
}