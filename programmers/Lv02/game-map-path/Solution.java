class Location{

    int x, y;

    Location(int x, int y) { this.x=x; this.y=y;}

    //현재 위치와 다른 위치가 같은지 비교
    public boolean equals(Location other) {
        return this.x==other.x && this.y==other.y;
    }

    Location left() {return new Location(x-1, y); }
    Location right() {return new Location(x+1, y); }
    Location up() {return new Location(x, y-1); }
    Location down() {return new Location(x, y+1); }

}

class Position {

    int steps; // 시작->현재위치까지 이동한 걸음 수
    Location location; // 현재 탐색 중인 위치
    Position(Location l, int s) { location=l; steps=s;}
}

public int solution(int[][] maps) {
    
    final int mapSizeX = maps.length; //가로
    final int mapSizeY = maps[0].length; //세로
    final Location target = new Location(mapSizeX-1, mapSizeY-1); // 목표지점
    boolean[][] visited = new boolean[mapSizeX][mapSizeY]; //각 위치 방문여부 

    // BFS
    Queue<Position> queue = new LinkedList<>();
    queue.add(new Position(new Location(0,0), 1));// 시작지점을 대기열에 추가

    while(!queue.isEmpty()){
        
      Position now = queue.poll(); // 현재 위치 대기열에서 꺼냄
          // 현재 방문 위치가 맵 범위에서 벗어나면 다음 위치로 넘어감.
          if(now.location.x <0 ) continue;
          if(now.location.x >= mapSizeX) continue;
          if(now.location.y <0 ) continue;
          if(now.location.y >= mapSizeY) continue;
          if(maps[now.location.x][now.location.y]==0) continue;// 벽
          if(visited[now.location.x][now.location.y]) continue; // 이미 방문했는지

          // 목표 위치에 도착하면 걸음 수 반환
          if(now.location.equals(target)){
              return now.steps;
          }

          visited[now.location.x][now.location.y] = treu; // 방문체크

          // 다음에 방문할 위치들을 대기열에 추가
          queue.offer(new Position(now.location.left(), now.steps+1));
          queue.offer(new Position(now.location.right(), now.steps+1));
          queue.offer(new Position(now.location.up(), now.steps+1));
          queue.offer(new Position(now.location.down(), now.steps+1));
    }
    
    return -1; // 타겟에 도달할 수 없는 경우

}
