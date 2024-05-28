    package com.example.cross_prog_2.task;

    import jakarta.validation.constraints.NotNull;

    import java.time.LocalDateTime;

    public class CreateTaskParameters {
        private TodoTask task;
        private boolean important;
        private boolean checked;
        private LocalDateTime date;

        public CreateTaskParameters(TodoTask task, boolean important, boolean checked, LocalDateTime date) {
            this.task = task;
            this.important = important;
            this.checked = checked;
            this.date = date;
        }


        public TodoTask getTask() {
            return task;
        }

        public boolean isImportant() {
            return important;
        }

        public boolean isChecked() {
            return checked;
        }

        public LocalDateTime getDate() {
            return date;
        }
    }
