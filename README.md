Scenario
You are building a Spring Boot REST API called Employee Management API that manages
a collection of employees.
Each Employee has:
• id (auto-generated)
• firstName
• lastName
• email
• department
• salary
API clients (via Postman) can:
• List all employees at GET /employees
• Get a single employee at GET /employees/{id}
• Create an employee at POST /employees (JSON body)
• Delete an employee at DELETE /employees/{id}
• Search by first name at GET /employees/search?firstName=...
• Search by department at GET /employees/byDepartment?department=...
• Search by exact email at GET /employees/byEmail?email=... (custom JPQL query)

==================

• @GetMapping → findAll() — returns List<EmployeeDto>.
• @GetMapping("/{id}") → findById(@PathVariable Long id) — returns EmployeeDto.
• @PostMapping → save(@Valid @RequestBody EmployeeDto employeeDto) —
returns EmployeeDto.
• @DeleteMapping("/{id}") → delete(@PathVariable Long id) — returns void.
• @GetMapping("/search") → findByFirstName(@RequestParam String firstName) —
returns List<EmployeeDto>.
• @GetMapping("/byDepartment") → findByDepartment(@RequestParam String
department) — returns List<EmployeeDto>.
• @GetMapping("/byEmail") → searchByEmail(@RequestParam String email) —
returns List<EmployeeDto>.
