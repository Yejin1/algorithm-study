
// 프로그래머스
// 완주하지 못한 선수
// 유형 : 자료구조
// https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=javascript



function solution(participant, completion) {
    var answer = '';
    let map = new Map();

    for(var i=0; i<participant.length; i++) {
        if(!map.has(participant[i]))
            map.set(participant[i],1);
        else
            map.set(participant[i],map.get(participant[i])+1);

    }

    for(var i=0; i<completion.length; i++) {
        if(map.has(completion[i])) {
            map.set(completion[i], map.get(completion[i])-1);
            if(map.get(completion[i])==0)
                map.delete(completion[i]);
        }
    }

    answer = map.keys().next().value;

    return answer;
}