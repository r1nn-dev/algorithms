// Solution1: HashMap + 정렬 방식 (권장)

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
        // 1. 장르별 총 재생 횟수를 저장한다.
        Map<String, Integer> genreTotalMap = new HashMap<>();
        // 2. 장르별 노래 목록을 저장한다.
        Map<String, List<Song>> genreSongsMap = new HashMap<>();

        // 3. 모든 노래를 순회하면서 장르별 정보들을 구성한다.
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 4. 현재 장르의 총 재생 횟수에 현재 노래의 재생 횟수를 누적한다.
            genreTotalMap.put(genre, genreTotalMap.getOrDefault(genre, 0) + play);

            // 5. 현재 장르의 노래 목록이 아직 없으면 새 리스트를 만든다. 
            genreSongsMap.putIfAbsent(genre, new ArrayList<>());
            
            // 6. 현재 노래의 고유 번호와 재생 횟수를 장르별 노래 목록에 추가한다. 
            genreSongsMap.get(genre).add(new Song(i, play));
        }
        
        // 7. 장르 목록을 만든다. 
        List<String> genreList = new ArrayList<>(genreTotalMap.keySet());
        // 8. 장르를 총 재생 횟수 기준으로 내림차순 정렬한다. 
        genreList.sort((g1, g2) -> Integer.compare(genreTotalMap.get(g2), genreTotalMap.get(g1)));
        
        // 9. 최종적으로 선택된 노래의 고유 번호를 저장한다. 
        List<Integer> answerList = new ArrayList<>();

        // 10. 총 재생 횟수가 높은 장르부터 처리한다.
        for (String genre : genreList) {
            List<Song> songList = genreSongsMap.get(genre);

            // 11. 장르 내부의 곡을 정렬한다. 
            // 재생 횟수가 높은 곡이 먼저 오고, 재생 횟수가 같으면 고유 번호가 낮은 곡이 먼저 온다.
            songList.sort((s1, s2) -> {
                if (s1.play != s2.play) {
                    return Integer.compare(s2.play, s1.play);
                }

                return Integer.compare(s1.index, s2.index);
            });
            
            // 12. 각 장르에서는 최대 2곡까지만 선택한다.
            int count = Math.min(2, songList.size());
            
            for (int i = 0; i < count; i++) {
                answerList.add(songList.get(i).index);
            }
        }

        // 13. List<Integer>를 int[]로 변환한다.
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
