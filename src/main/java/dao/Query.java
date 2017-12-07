package dao;

interface Query {
    String CREATE_REQUEST = "INSERT INTO REQUESTS(id, name, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)";

    String GET_REQUESTS_BY_CUSTOMER = "SELECT * FROM REQUESTS WHERE name = ?";

    String UPDATE_REQUEST_STATUS = "UPDATE REQUESTS SET status = ? WHERE id = ?";

    String DELETE_REQUESTS_BY_NAME = "DELETE REQUESTS WHERE name = ?";
}
