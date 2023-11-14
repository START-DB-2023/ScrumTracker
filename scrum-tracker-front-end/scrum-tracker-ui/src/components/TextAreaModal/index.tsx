import {useState} from 'react';

interface TextAreaModal {
    id: string;
}

const TextAreaModal: React.FC<TextAreaModal> = ({id}) => {
    const [textValue, setTextValue] = useState<string>('');
  const [textareaStyle, setTextareaStyle] = useState<React.CSSProperties>({
    width: 'auto',
    minHeight: '5.6rem', // Altura mínima desejada
  });

  const handleTextChange = (event: React.ChangeEvent<HTMLTextAreaElement>) => {
    const value = event.target.value;

    // Atualizar o valor do text
    setTextValue(value);

    // Ajustar a altura conforme o comprimento do texto
    setTextareaStyle({
      ...textareaStyle,
      height: `${Math.max(30, event.target.scrollHeight)}px`,
    }); 
  };


    return(
          <textarea id={id} name={id} value={textValue} onChange={handleTextChange} style={textareaStyle}></textarea>
    );
};

export default TextAreaModal;