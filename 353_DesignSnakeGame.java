class SnakeGame {
    private int snakeLength, score, xPos, yPos, foodX, foodY, fI;
    private Queue<Integer> qX = new LinkedList<Integer>();
    private Queue<Integer> qY = new LinkedList<Integer>();
    private int[][] food;
    
    private boolean[][] board;
    
    public SnakeGame(int width, int height, int[][] food) {
        board = new boolean[height][width];
        this.food = food;
        for(boolean[] row: board)
            Arrays.fill(row, false);
        snakeLength = 1;
        xPos = 0;
        yPos = 0;
        board[xPos][yPos] = true;
        foodX = food[0][1];
        foodY = food[0][0];
        fI = 0;
        qX.add(xPos);
        qY.add(yPos);
    }
    
    public int move(String direction) {
        switch(direction){
            case "R":
                if(xPos + 1 == board[0].length)
                    return -1;
                if(fI < food.length && xPos + 1 == foodX && yPos == foodY){
                    board[foodY][foodX] = true;
                    xPos = foodX;
                    yPos = foodY;
                    score++;
                    fI++;
                    if(fI < food.length){
                        foodX = food[fI][1];
                        foodY = food[fI][0];
                    }
                }
                else{
                    board[qY.poll()][qX.poll()] = false;
                    xPos = xPos + 1;
                    if(board[yPos][xPos])
                        return -1;
                    board[yPos][xPos]  = true;
                }
                qX.add(xPos);
                qY.add(yPos);
                break;
            case "D":
                if(yPos + 1 == board.length)
                    return - 1;
                if(fI < food.length && yPos + 1 == foodY && xPos == foodX){
                    board[foodY][foodX] = true;
                    xPos = foodX;
                    yPos = foodY;
                    score++;
                    fI++;
                    if(fI < food.length){
                        foodX = food[fI][1];
                        foodY = food[fI][0];
                    }
                }
                else{
                    board[qY.poll()][qX.poll()] = false;
                    yPos = yPos + 1;
                    if(board[yPos][xPos])
                        return -1;
                    board[yPos][xPos]  = true;
                }
                qX.add(xPos);
                qY.add(yPos);
                break;
            case "L":
                if(xPos - 1 == -1)
                    return -1;
                if(fI < food.length && xPos - 1 == foodX && yPos == foodY){
                    board[foodY][foodX] = true;
                    xPos = foodX;
                    yPos = foodY;
                    score++;
                    fI++;
                    if(fI < food.length){
                        foodX = food[fI][1];
                        foodY = food[fI][0];
                    }
                }
                else{
                    board[qY.poll()][qX.poll()] = false;
                    xPos = xPos - 1;
                    if(board[yPos][xPos])
                        return -1;
                    board[yPos][xPos]  = true;
                }
                qX.add(xPos);
                qY.add(yPos);
                break;
            case "U":
                if(yPos - 1 == -1)
                    return -1;
                if(fI < food.length && yPos - 1 == foodY && xPos == foodX){
                    board[foodY][foodX] = true;
                    xPos = foodX;
                    yPos = foodY;
                    score++;
                    fI++;
                    if(fI < food.length){
                        foodX = food[fI][1];
                        foodY = food[fI][0];
                    }
                }
                else{
                    board[qY.poll()][qX.poll()] = false;
                    yPos = yPos - 1;
                    if(board[yPos][xPos])
                        return -1;
                    board[yPos][xPos]  = true;
                }
                qX.add(xPos);
                qY.add(yPos);
                break;
        }
        return score;
        
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */