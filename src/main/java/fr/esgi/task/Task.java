package fr.esgi.task;

public class Task {
    //declaration des variables de la classe Task
    private int id;
    private String description;
    private Boolean isDone;

    //CONSTRUCTOR
    public Task(int id, String description, Boolean isDone) {
        this.id = id;
        this.description = description;
        this.isDone = isDone;
    }

    public Task() {

    }


    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;

        if (getId() != task.getId()) return false;
        if (!getDescription().equals(task.getDescription())) return false;
        return isDone.equals(task.isDone);
    }

   @Override
    public String toString() {
        return "Task" + id +" : { " +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                " }";
    }
}
