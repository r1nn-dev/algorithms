// Solution2: HashMap + 장르별 Top 2 유지 방식

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

    static class TopSongs { 
        Song first; 
        Song second; 
        
        void add(Song current) { 
            // 1. 현재 곡이 기존 1등보다 좋으면 1등을 2등으로 내리고 현재 곡을 1등으로 만든다. 
            if (first == null || isBetter(current, first)) { 
                second = first; first = current; 
            } 
            // 2. 현재 곡이 1등은 아니지만 기존 2등보다 좋으면 2등으로 저장한다. 
            else if (second == null || isBetter(current, second)) { 
                second = current; 
            } 
        } 
        
        private boolean isBetter(Song a, Song b) { 
            // 3. 재생 횟수가 다르면 재생 횟수가 높은 곡이 더 좋은 곡이다. 
            if (a.play != b.play) { 
                return a.play > b.play; 
            }
            // 4. 재생 횟수가 같으면 고유 번호가 낮은 곡이 더 좋은 곡이다. 
            return a.index < b.index; 
        } 
    }

  
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 횟수를 저장한다.
        Map<String, Integer> genreTotalMap = new HashMap<>();
        // 2. 장르별 상위 2곡만 저장한다.
        Map<String, List<Song>> genreSongsMap = new HashMap<>();

        // 3. 모든 노래를 순회한다.
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 4. 장르별 총 재생 횟수를 누적한다.
            genreTotalMap.put(genre, genreTotalMap.getOrDefault(genre, 0) + play);

            // 5. 현재 장르의 TopSongs 객체가 없으면 새로 만든다. 
            genreSongsMap.putIfAbsent(genre, new ArrayList<>());
            
            // 6. 현재 노래가 해당 장르의 상위 2곡 안에 들어갈 수 있는지 확인한다. 
            genreTopSongsMap.get(genre).add(new Song(i, play)); 
        }
        
        // 7. 장르 목록을 만든다. 
        List<String> genreList = new ArrayList<>(genreTotalMap.keySet());
        // 8. 장르를 총 재생 횟수 기준으로 내림차순 정렬한다. 
        genreList.sort((g1, g2) -> Integer.compare(genreTotalMap.get(g2), genreTotalMap.get(g1))); 
        
        // 9. 최종적으로 선택된 노래의 고유 번호를 저장한다.
        List<Integer> answerList = new ArrayList<>();

        // 10. 정렬된 장르 순서대로 각 장르의 1등, 2등 노래를 결과에 추가한다. 
        for (String genre : genreList) {
            TopSongs topSongs = genreTopSongsMap.get(genre);

            if (topSongs.first != null) { 
                answerList.add(topSongs.first.index); 
            } 
            if (topSongs.second != null) { 
                answerList.add(topSongs.second.index); 
            }
        }

        // 11. List<Integer>를 int[]로 변환한다.
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
