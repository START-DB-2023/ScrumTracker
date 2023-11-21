export const tokenService = {

    save(key: string, value: string){
        return localStorage.setItem(key,value);
    },

    get(key: string){
        return localStorage?.getItem(key);
    },

    delete(key: string){
        return localStorage?.removeItem(key);
    },
    
    clear(){
        return localStorage.clear();
    }
}

