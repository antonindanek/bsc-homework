package homework.data.parser;


/**
 * 
 * Due to simplicity of this project, parser doubles also as a validator.
 */
public interface Parser<T> {

    T parse(String input);
    
}
