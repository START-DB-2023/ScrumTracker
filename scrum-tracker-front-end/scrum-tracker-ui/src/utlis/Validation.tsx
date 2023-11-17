function validateEmail(email: string) {
    if (!email || email.trim() === '') {
        return { isValid: false, message: 'O campo E-mail é obrigatório' };
    }

    if (email !== email.trim()) {
        return { isValid: false, message: 'E-mail inválido' };
    }

    if (!email.includes('@') || !email.includes('.')) {
        return { isValid: false, message: 'E-mail inválido' };
    }

    if (email[0] === '.' || email[email.length - 1] === '.') {
        return { isValid: false, message: 'E-mail inválido' };
    }

    const atIndex = email.indexOf('@');
    const dotIndex = email.indexOf('.', atIndex);

    if (dotIndex === 0 || dotIndex === email.length - 1) {
        return { isValid: false, message: 'E-mail inválido' };
    }

    for (let i = 1; i < email.length - 1; i++) {
        if (email[i] === '.' && email[i - 1] === '.') {
            return { isValid: false, message: 'E-mail inválido' };
        }
        if (email[i] === '.' || email[i] === '@') {
            if (email[i - 1] === '.' || email[i - 1] === '@' || email[i + 1] === '.' || email[i + 1] === '@') {
                return { isValid: false, message: 'E-mail inválido' };
            }
        }
    }

    return { isValid: true };
}


export {validateEmail}