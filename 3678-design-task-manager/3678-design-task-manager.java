class TaskManager {
    private static TreeSet<Task> tasks;
    private static Map<Integer, Task> map;

    public TaskManager(List<List<Integer>> taskList) {
        tasks = new TreeSet<>((a, b) -> {
            if (a.priority == b.priority) 
                return b.taskId - a.taskId;
            return b.priority - a.priority;
        });
        map = new HashMap<>();
        for (List<Integer> task : taskList) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        tasks.add(task);
        map.put(taskId, task);
    }

    public void edit(int taskId, int newPriority) {
        if (!map.containsKey(taskId)) return;

        Task oldTask = map.get(taskId);
        tasks.remove(oldTask);
        oldTask.updatePriority(newPriority);
        tasks.add(oldTask);
    }

    public void rmv(int taskId) {
        if (!map.containsKey(taskId)) return;

        Task task = map.get(taskId);
        tasks.remove(task);
        map.remove(taskId);
    }

    public int execTop() {
        if (tasks.isEmpty()) return -1;

        Task topTask = tasks.pollFirst();
        map.remove(topTask.taskId);
        return topTask.userId;
    }
}

class Task {
    int userId, taskId, priority;

    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }

    public void updatePriority(int newPriority) {
        this.priority = newPriority;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return taskId == task.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
}


/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */