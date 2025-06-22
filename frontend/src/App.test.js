import { render, screen } from '@testing-library/react';
import App from './App';

// Teste automático de exemplo gerado pelo React
test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
