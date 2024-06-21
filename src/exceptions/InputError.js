const ClientError = require("../exceptions/ClientError.js");

class InputError extends ClientError {
    constructor(message) {
        super(message);
        this.name = 'InputError';
    }
}

module.exports = InputError;