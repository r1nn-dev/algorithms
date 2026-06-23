// Solution1: HashMap + 정렬 방식 

import java.util.*;

class Solution {
    static class Song {
        int index;
        int play;

        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalMap = new HashMap<>();
        Map<String, List<Song>> genreSongsMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 장르별 총 재생 횟수를 누적한다.
            genreTotalMap.put(genre, genreTotalMap.getOrDefault(genre, 0) + play);

            // 장르별 노래 목록을 초기화한 뒤 현재 노래를 추가한다.
            genreSongsMap.putIfAbsent(genre, new ArrayList<>());
            genreSongsMap.get(genre).add(new Song(i, play));
        }
        
        // 장르를 총 재생 횟수 기준으로 내림차순 정렬한다.
        List<String> genreList = new ArrayList<>(genreTotalMap.keySet());
        genreList.sort((g1, g2) -> Integer.compare(genreTotalMap.get(g2), genreTotalMap.get(g1)));
        
        List<Integer> answerList = new ArrayList<>();
        
        for (String genre : genreList) {
            List<Song> songList = genreSongsMap.get(genre);

            // 장르 내부의 곡을 재생 횟수 내림차순, 고유 번호 오름차순으로 정렬한다.
            songList.sort((s1, s2) -> {
                if (s1.play != s2.play) {
                    return Integer.compare(s2.play, s1.play);
                }

                return Integer.compare(s1.index, s2.index);
            });
            
            // 각 장르에서 최대 2곡까지만 선택한다.
            int count = Math.min(2, songList.size());
            
            for (int i = 0; i < count; i++) {
                answerList.add(songList.get(i).index);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
