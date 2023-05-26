package fr.esgi.task;

public class Task {
    //declaration des variables de la classe Task
    private final Long id;
    private String description;
    private Boolean isDone;

    private static Long counter = 0L;

    //CONSTRUCTOR

    public Task() {
        id = ++counter;
    }

    public Task(String description) {
        this();
        this.description = description;

    }
    public Task( String description, Boolean isDone) {
        this();
        this.description = description;
        this.isDone = isDone;
    }



    // Getters et Setters


    public Long getId () {
        return id;
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
