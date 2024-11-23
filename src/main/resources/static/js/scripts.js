$(document).ready(function () {
    // Detectar cambios en los filtros mientras se escribe
    $('#filterName, #filterDescription, #filterStatus, #filterDueDate').on('input', function () {
        filterTasks(); // Llamar a la función de filtrado cada vez que el usuario escribe
    });

	function filterTasks() {
	    var filterData = $('#filterForm').serialize();

	    $.get('/tasks/filter', filterData, function (response) {
	        var tasksHtml = '<div class="row g-4">'; // Inicia una nueva fila con espacio entre elementos

	        response.forEach(function (task) {
	            tasksHtml += `
	                <div class="col-md-6">
	                    <li class="task-item list-group-item">
	                        <h3 class="task-title">${task.name}</h3>
	                        <div class="task-section task-description">
	                            <h5>Description:</h5>
	                            <p>${task.description}</p>
	                        </div>
	                        <div class="task-section task-status">
	                            <h5>Status:</h5>
	                            <p>${task.status}</p>
	                        </div>
	                        <div class="task-section task-due-date">
	                            <h5>Due Date:</h5>
	                            <p>${task.dueDate}</p>
	                        </div>
	                        <div class="task-actions">
	                            <form action="/tasks/delete" method="post" style="display:inline;">
	                                <input type="hidden" name="id" value="${task.id}">
	                                <button type="submit" class="btn btn-danger btn-sm">Delete</button>
	                            </form>
	                            <form action="/editTask/${task.id}" method="get" style="display:inline;">
	                                <button type="submit" class="btn btn-warning btn-sm">Edit</button>
	                            </form>
	                        </div>
	                    </li>
	                </div>
	            `;
	        });

	        tasksHtml += '</div>'; // Cierra la fila
	        $('#tasksGrid').html(tasksHtml); // Actualiza la grilla
	    });
	}






});
